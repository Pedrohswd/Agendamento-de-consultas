import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Form, FormGroup } from '@angular/forms';
import { API_CONFIG } from 'app/config/API_CONFIG';
import { Observable } from 'rxjs';
import { Medico } from 'app/models/medico';

@Injectable({
  providedIn: 'root'
})
export class MedicoService {

  constructor(private _httpClient: HttpClient) { }

  findAll(): Observable<Medico[]>{
    return this._httpClient.get<Medico[]>(`${API_CONFIG.baseUrl}/medico`);
  }

  create(medicoForm: FormGroup): Observable<Medico> {
    const medico = new Medico(medicoForm);
    return this._httpClient.post<Medico>(`${API_CONFIG.baseUrl}/medico`, medico);
  }
}
