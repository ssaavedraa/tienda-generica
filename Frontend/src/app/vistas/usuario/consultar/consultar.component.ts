import { ValueTransformer } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { listaUsuariosInt } from 'src/app/modelos/listarUsuarios.interface';
import { UsuariosApiService } from 'src/app/servicios/api/usuarios/usuarios-api.service';

@Component({
  selector: 'app-consultar',
  templateUrl: './consultar.component.html',
  styleUrls: ['./consultar.component.css']
})
export class ConsultarComponent implements OnInit {

  usuarios:listaUsuariosInt[];

  constructor(private api:UsuariosApiService, private router:Router, private activerouter:ActivatedRoute) {
    this.usuarios = [];
   }

  ngOnInit(): void {
    this.api.getUsuarios().subscribe(data =>{
      for (let usuario of data){
        if (usuario.nombre_usuario !== 'admin'){
          this.usuarios.push(usuario)
        }
      }
    })
  }

  actualizarUsuario(cedulaUsuario){
    this.router.navigate(['actualizarUsr', cedulaUsuario])
  }

}
