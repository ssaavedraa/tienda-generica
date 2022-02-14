import { Injectable } from '@angular/core';
import {LoginInt} from '../../../modelos/login.interface'
import {ResponseInt} from '../../../modelos/response.interface'
import {HttpClient, HttpClientModule, HttpHeaders} from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginApiService {

  url = 'http://localhost:8080/users/'

  constructor(private http:HttpClient) { }

  userLogin(form:LoginInt):Observable<ResponseInt>{
    let direccion = this.url + "auth"
    return this.http.post<ResponseInt>(direccion, form);
  }
}
