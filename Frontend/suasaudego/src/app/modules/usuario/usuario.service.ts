import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API_CONFIG } from 'app/config/API_CONFIG';
import { Usuario } from 'app/models/usuario';
import { BehaviorSubject, Observable, map, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdministradorService {

  private _usuario: BehaviorSubject<Usuario[]> = new BehaviorSubject<
    Usuario[]
  >(null);

  constructor(private _httpClient: HttpClient) { }

  get usuario$(): Observable<Usuario[]> {
    return this._usuario.asObservable();
  }

  getCertificateById(eventId: String): Observable<any> {
    return this._usuario.pipe(
      map((events: any[]) =>
        events.find((event) => event.id === eventId)
      )
    );
  }

  findUsuarios(): Observable<Usuario[]> {
    return this._httpClient
        .get<Usuario[]>(`${API_CONFIG.baseUrl}/usuario/perfis`)
        .pipe(
            tap((unidades: Usuario[]) => {
                this._usuario.next(unidades);
            })
        );
}

}
