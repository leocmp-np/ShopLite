import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Product } from '../../models/product';
import { OnInit, OnChanges, OnDestroy, SimpleChanges } from '@angular/core';

@Component({
  imports: [],
  selector: 'app-product-card',
  styleUrl: './product-card.css',
  templateUrl: './product-card.html',
})
export class ProductCard implements OnInit, OnChanges, OnDestroy{

  @Input() product!:Product;

  @Output() deleteProduct = new EventEmitter<number>()

  onDelete(){
    this.deleteProduct.emit(this.product.id);
  }
  constructor() {
    console.log("Constructor");
  }

  ngOnInit(): void {
    console.log("OnInit", this.product.name);
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log("OnChanges", changes);
  }

  ngOnDestroy(): void {
    console.log("OnDestroy", this.product.name);
  }


}
