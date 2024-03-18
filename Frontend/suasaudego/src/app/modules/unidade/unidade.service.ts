import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API_CONFIG } from 'app/config/API_CONFIG';
import { Unidade } from 'app/models/unidade';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UnidadeService {

  constructor(private _httpClient: HttpClient) { }


  findAll(): Observable<Unidade[]> {
    return this._httpClient.get<Unidade[]>(`${API_CONFIG.baseUrl}/unidade`);
  }

  create(unidade: Unidade): Observable<Unidade> {
    return this._httpClient.post<Unidade>(`${API_CONFIG.baseUrl}/unidade`, unidade);
  }
}
