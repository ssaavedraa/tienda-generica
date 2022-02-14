import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UsuarioInt } from 'src/app/modelos/Usuario.interface';
import { UsuariosApiService } from 'src/app/servicios/api/usuarios/usuarios-api.service';

@Component({
  selector: 'app-actualizar',
  templateUrl: './actualizar.component.html',
  styleUrls: ['./actualizar.component.css']
})
export class ActualizarComponent implements OnInit {

  cedulaUsuario:any = 0;
  datosUsuario: UsuarioInt | undefined;

  actualizarForm = new FormGroup({
    cedula_usuario : new FormControl(''),
    email_usuario : new FormControl(''),
    nombre_usuario : new FormControl(''),
    usuario : new FormControl(''),
    password : new FormControl(''),
  })

  constructor(private api:UsuariosApiService, private activeroute:ActivatedRoute, private router:Router) {
  }

  ngOnInit(): void {
    this.cedulaUsuario = this.activeroute.snapshot.paramMap.get('cedula');
    this.api.getUsuario(this.cedulaUsuario).subscribe(data => {
      this.actualizarForm.setValue({
        cedula_usuario : data['cedula_usuario'],
        email_usuario : data['email_usuario'],
        nombre_usuario : data['nombre_usuario'],
        usuario : data['usuario'],
        password : data['password']
      })
    });
  }

  cancelar(){
    this.router.navigate([''])
  }

  updateForm(form:UsuarioInt){
    this.api.updateUsuario(form).subscribe(data => {
      alert("Usuario actualizado con exito");
      this.router.navigate(['']);
    })
  }

}
