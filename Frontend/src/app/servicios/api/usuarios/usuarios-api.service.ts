import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UsuarioInt } from 'src/app/modelos/Usuario.interface';
import { listaUsuariosInt } from 'src/app/modelos/listarUsuarios.interface';
import { ResponseInt } from 'src/app/modelos/response.interface';

@Injectable({
  providedIn: 'root'
})
export class UsuariosApiService {

  url = 'http://localhost:8080/users/'

  constructor(private http:HttpClient) { }

  getUsuarios():Observable<listaUsuariosInt[]>{
    let direccion = this.url + "read";
    return this.http.get<listaUsuariosInt[]>(direccion);
  }

  getUsuario(cedulaUsuario:number):Observable<UsuarioInt[]>{
    let direccion = this.url + "read/" + cedulaUsuario;
    return this.http.get<UsuarioInt[]>(direccion);
  }

  updateUsuario(form:UsuarioInt):Observable<ResponseInt>{
    let direccion = this.url + form.cedula_usuario;
    return this.http.put<ResponseInt>(direccion, form);
  }

  deleteUsuario(cedulaUsuario):Observable<ResponseInt>{
    let direccion = this.url + cedulaUsuario
    let options = {
      headers: new HttpHeaders({
        'Content-type': 'application/json'
      }),
      body:cedulaUsuario
    }
    return this.http.delete<ResponseInt>(direccion, options);
  }

  createUsuario(form:UsuarioInt):Observable<ResponseInt>{
    let direccion = this.url + 'add';
    return this.http.post<ResponseInt>(direccion, form);
  }

}
