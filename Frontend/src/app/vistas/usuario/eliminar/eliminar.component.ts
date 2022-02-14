import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsuariosApiService } from 'src/app/servicios/api/usuarios/usuarios-api.service';

@Component({
  selector: 'app-eliminar',
  templateUrl: './eliminar.component.html',
  styleUrls: ['./eliminar.component.css']
})
export class EliminarComponent implements OnInit {

  constructor(private api:UsuariosApiService,private router:Router) { }

  ngOnInit(): void {
  }

  eliminar(cedulaUsuario){
    this.api.deleteUsuario(cedulaUsuario).subscribe(data => {
      let dataResponse = data;
      if(dataResponse.status == "OK"){
        alert('Usuario eliminado con éxito');
        this.router.navigate(['home']);
      }else{
        alert('El usuario no se encontró');
      }
    })
  }

}
