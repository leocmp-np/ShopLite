//product: productResponseDTO
export interface Product {
 
    id:number;
    name:string;
    description:string;
    price:number;
    quantity:number;
    category:string;

}

//productRequestDTO
export interface ProductRequest{

    name:string;
    description:string;
    price:number;
    quantity:number;
    category:string;

}