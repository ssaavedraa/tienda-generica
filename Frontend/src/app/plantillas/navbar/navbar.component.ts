import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ActualizarComponent } from 'src/app/vistas/usuario/actualizar/actualizar.component';
import { ConsultarComponent } from 'src/app/vistas/usuario/consultar/consultar.component';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  session: string;

  constructor(private modalService: NgbModal, private router:Router) {
    this.session = "Iniciar sesión"
  }

  ngOnInit(): void {
    this.checkSession();
  }

  checkSession(){
    if (localStorage.getItem('nombre')){
      this.session = "Cerrar sesion"
      return true;
    }
    return false;
  }

  closeSession(){
    localStorage.removeItem('nombre');
    this.router.navigate(['']);
  }

}
