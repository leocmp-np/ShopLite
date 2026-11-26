import { Component, OnInit, signal } from '@angular/core';
import { ProductService } from '../../services/productService';
import { Product } from '../../models/product';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { filter, map, tap } from 'rxjs';
import {
  debounceTime,
  distinctUntilChanged,
  switchMap
} from 'rxjs';
import { ProductCard } from '../product-card/product-card';


@Component({
  imports: [ReactiveFormsModule, ProductCard],
  selector: 'app-product-list',
  styleUrl: './product-list.css',
  templateUrl: './product-list.html',
})
export class ProductList implements OnInit {

  constructor(private prodService: ProductService){}
  searchControl = new FormControl('',{nonNullable:true })

  products = signal<Product[]>([]);

  ngOnInit(){
    this.prodService.getAllProducts()
    .pipe(tap(products => console.log(products)),map(products => products.filter(p=>p.quantity > 0)))
    .subscribe({
      next:data =>{this.products.set(data)},
      error:error=>{console.error(error)}
    })

    this.searchControl.valueChanges
    .pipe(
      debounceTime(300),
      distinctUntilChanged(),
      switchMap(word =>
      word.trim() === ''
        ? this.prodService.getAllProducts()
        : this.prodService.searchProducts(word)
      )   
    )
    .subscribe({
      next: data => this.products.set(data),
      error: err => console.error(err)
    });
  }

  removeProduct(id: number): void {
    console.log("Chiamato")
    this.prodService.deleteProduct(id).subscribe({
      next: () => {
        this.products.update(products => products.filter(p => p.id !== id));
      },
      error: err => {
        console.error("Errore durante l'eliminazione", err);
      }
  });

  }
}