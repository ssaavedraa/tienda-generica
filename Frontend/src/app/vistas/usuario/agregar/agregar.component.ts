import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, RequiredValidator, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UsuarioInt } from 'src/app/modelos/Usuario.interface';
import { UsuariosApiService } from 'src/app/servicios/api/usuarios/usuarios-api.service';

@Component({
  selector: 'app-agregar-usr',
  templateUrl: './agregar.component.html',
  styleUrls: ['./agregar.component.css']
})
export class AgregarComponent implements OnInit {

  crearForm = new FormGroup({
    cedula_usuario : new FormControl('', Validators.required),
    email_usuario : new FormControl('', Validators.required),
    nombre_usuario : new FormControl('', Validators.required),
    usuario : new FormControl('', Validators.required),
    password : new FormControl('', Validators.required)
  });

  constructor(private api:UsuariosApiService, private router:Router) { }

  ngOnInit(): void {
  }

  postForm(form:UsuarioInt){
    this.api.createUsuario(form).subscribe(data => {
      alert('Usuario creado con exito');
      this.router.navigate(['']);
    })
  }

}
