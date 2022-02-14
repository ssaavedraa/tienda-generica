import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './plantillas/navbar/navbar.component';
import { FooterComponent } from './plantillas/footer/footer.component';

import { ReactiveFormsModule, FormsModule } from '@angular/forms'
import { HttpClientModule } from '@angular/common/http';
import { EliminarComponent } from './vistas/usuario/eliminar/eliminar.component';
import { CrearClienteComponent } from './vistas/clientes/crear-cliente/crear-cliente.component';
import { ConsultarClienteComponent } from './vistas/clientes/consultar-cliente/consultar-cliente.component';
import { ActualizarClienteComponent } from './vistas/clientes/actualizar-cliente/actualizar-cliente.component';
import { EliminarClienteComponent } from './vistas/clientes/eliminar-cliente/eliminar-cliente.component';
import { CrearProveedorComponent } from './vistas/proveedores/crear-proveedor/crear-proveedor.component';
import { ConsultarProveedorComponent } from './vistas/proveedores/consultar-proveedor/consultar-proveedor.component';
import { ActualizarProveedorComponent } from './vistas/proveedores/actualizar-proveedor/actualizar-proveedor.component';
import { EliminarProveedorComponent } from './vistas/proveedores/eliminar-proveedor/eliminar-proveedor.component';
import { ProductosComponent } from './vistas/productos/productos.component';
import { ReportesComponent } from './vistas/reportes/reportes.component';
import { VentasComponent } from './vistas/ventas/ventas.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    routingComponents,
    EliminarComponent,
    CrearClienteComponent,
    ConsultarClienteComponent,
    ActualizarClienteComponent,
    EliminarClienteComponent,
    CrearProveedorComponent,
    ConsultarProveedorComponent,
    ActualizarProveedorComponent,
    EliminarProveedorComponent,
    ProductosComponent,
    ReportesComponent,
    VentasComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
