import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { listaProveedoresInt } from 'src/app/modelos/listaProveedores.interface';
import { ResponseInt } from 'src/app/modelos/response.interface';

@Injectable({
  providedIn: 'root'
})
export class ProveedoresApiService {

  url = 'http://localhost:8080/proveedores/'

  constructor(private http:HttpClient) { }

  getProveedores():Observable<listaProveedoresInt[]>{
    let direccion = this.url + "read";
    return this.http.get<listaProveedoresInt[]>(direccion);
  }

  getProveedor(nitProveedor:number):Observable<listaProveedoresInt[]>{
    let direccion = this.url + "read/" + nitProveedor;
    return this.http.get<listaProveedoresInt[]>(direccion);
  }

  updateProveedor(form:listaProveedoresInt):Observable<ResponseInt>{
    let direccion = this.url + form.nit_proveedor;
    return this.http.put<ResponseInt>(direccion, form);
  }

  deleteProveedor(nitProveedor):Observable<ResponseInt>{
    let direccion = this.url + nitProveedor;
    let options = {
      headers: new HttpHeaders({
        'Content-type': 'application/json'
      }),
      body:nitProveedor
    }
    return this.http.delete<ResponseInt>(direccion, options);
  }

  createProveedor(form:listaProveedoresInt):Observable<ResponseInt>{
    let direccion = this.url + "add";
    return this.http.post<ResponseInt>(direccion, form);
  }

}
