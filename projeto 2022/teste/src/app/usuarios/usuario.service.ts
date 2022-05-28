import { Injectable } from '@angular/core';
import { Usuario } from './usuario.model';
import { Subject } from 'rxjs';


@Injectable({providedIn:"root"})
export class UsuarioService {
 private usuarios: Usuario[] = [];
 private listaUsuariosAtualizada = new Subject<Usuario[]>();

 getUsuarios(): Usuario[] {
 return [...this.usuarios];
 }
adicionarUsuario(usuario: string, senha: string) {
  const usuarios: Usuario = {
  usuario: usuario,
  senha: senha,
  };
  this.usuarios.push(usuarios);
  this.listaUsuariosAtualizada.next([...this.usuarios])
  }

  getListaDeUsuariosAtualizadaObservable() {
    return this.listaUsuariosAtualizada.asObservable();
    }
}
