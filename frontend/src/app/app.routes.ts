import { Routes } from '@angular/router';
import { ProductList } from './components/product-list/product-list';
import { ProductForm } from './components/product-form/product-form';

export const routes: Routes = [

    {
        path:'products',
        component:ProductList
    },

    {
        path:'products/new',
        component: ProductForm
    },

    {
        path: '',
        redirectTo: 'products',
        pathMatch: 'full'
    },

    {
        path: '**',
        redirectTo: 'products'
    }


];
