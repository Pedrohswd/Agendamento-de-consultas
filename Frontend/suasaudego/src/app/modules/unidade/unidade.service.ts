import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup, UntypedFormGroup } from '@angular/forms';
import { API_CONFIG } from 'app/config/API_CONFIG';
import { Unidade } from 'app/models/unidade';
import { BehaviorSubject, Observable, map, tap } from 'rxjs';

@Injectable({
    providedIn: 'root',
})
export class UnidadeService {
    private _unidades: BehaviorSubject<Unidade[]> = new BehaviorSubject<
        Unidade[]
    >(null);

    constructor(private _httpClient: HttpClient) { }

    get unidade$(): Observable<Unidade[]> {
        return this._unidades.asObservable();
    }

    getCertificateById(eventId: String): Observable<any> {
        return this._unidades.pipe(
            map((events: any[]) =>
                events.find((event) => event.cnes === eventId)
            )
        );
    }

    findByCNES(cnes: string): Observable<Unidade> {
        return this._httpClient.get<Unidade>(
            `${API_CONFIG.baseUrl}/unidade/cnes/${cnes}`
        );
    }

    findAll(): Observable<Unidade[]> {
        return this._httpClient
            .get<Unidade[]>(`${API_CONFIG.baseUrl}/unidade`)
            .pipe(
                tap((unidades: Unidade[]) => {
                    this._unidades.next(unidades);
                })
            );
    }

    create(unidade: Unidade): Observable<Unidade> {
        return this._httpClient.post<Unidade>(
            `${API_CONFIG.baseUrl}/unidade`,
            unidade
        );
    }

    update(unidade: Unidade): Observable<Unidade> {
        return this._httpClient.put<Unidade>(
            `${API_CONFIG.baseUrl}/unidade/${unidade.id}`,
            unidade
        );
    }
}
