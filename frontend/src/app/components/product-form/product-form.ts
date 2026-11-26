import { Component } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  ReactiveFormsModule
} from '@angular/forms';
import { ProductService } from '../../services/productService';


@Component({
  imports: [ReactiveFormsModule],
  selector: 'app-product-form',
  styleUrl: './product-form.css',
  templateUrl: './product-form.html',
})
export class ProductForm {

constructor(private prodService: ProductService){}

productForm = new FormGroup({
  name: new FormControl('', {
    nonNullable: true,
    validators: [Validators.required]
  }),
  description: new FormControl('', { nonNullable: true }),
  price: new FormControl(0, {
    nonNullable: true,
    validators: [Validators.required, Validators.min(0)]
  }),
  quantity: new FormControl(0, {
    nonNullable: true,
    validators: [Validators.required, Validators.min(0)]
  }),
  category: new FormControl('', {
    nonNullable: true,
    validators: [Validators.required]
  })
  });

  onSubmit(){
    if(this.productForm.invalid) return;

    const newProduct = this.productForm.getRawValue();
    this.prodService.addProduct(newProduct).subscribe({
      next: created => {console.log("Oggetto inviato",created);
                        this.productForm.reset();
      },
      error: err =>{console.log("Oggetto non creato",err)}
    })
  }

}
