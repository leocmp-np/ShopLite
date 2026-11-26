import { Injectable, Service } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product, ProductRequest } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

    private readonly apiUrl = 'http://localhost:8080/api/products';
    constructor(private http: HttpClient){}

    getAllProducts(): Observable<Product[]>{
        return this.http.get<Product[]>(this.apiUrl);
    }

    getProductById(id: number): Observable<Product>{
        return this.http.get<Product>(`${this.apiUrl}/${id}`);
    }

    addProduct(product: ProductRequest): Observable<Product> {
    return this.http.post<Product>(this.apiUrl, product);
    }
    
    updateProduct(id: number, product: ProductRequest): Observable<Product> {
    return this.http.put<Product>(`${this.apiUrl}/${id}`, product);
    }

    deleteProduct(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiUrl}/${id}`);
    }

    //requestParams
    getProductsByCategory(category: string): Observable<Product[]> {
        const params = new HttpParams().set('category', category);

        return this.http.get<Product[]>(
            `${this.apiUrl}/category`, {params}
        );
    }

    searchProducts(word: string): Observable<Product[]> {
        const params = new HttpParams().set('word', word);

        return this.http.get<Product[]>(
            `${this.apiUrl}/search`, {params}
        );
    }
}
