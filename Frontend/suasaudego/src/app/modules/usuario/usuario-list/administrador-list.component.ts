import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Usuario } from 'app/models/usuario';
import { AdministradorService } from '../usuario.service';

@Component({
  selector: 'app-administrador-list',
  templateUrl: './administrador-list.component.html',
  styleUrls: ['./administrador-list.component.scss']
})
export class AdministradorListComponent implements OnInit {

  ELEMENT_DATA: Usuario[] = []


  displayedColumns: string[] = ['id', 'email', 'pessoa',  'perfil', 'acoes'];
  dataSource = new MatTableDataSource<Usuario>(this.ELEMENT_DATA);

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private _service: AdministradorService) { }

  ngOnInit(): void {
    this.findUsuarios();
  }

  findUsuarios() {
    this._service.findUsuarios().subscribe(resposta => {
      console.log(resposta);
      this.ELEMENT_DATA = resposta
      this.dataSource = new MatTableDataSource<Usuario>(this.ELEMENT_DATA);
      this.dataSource.paginator = this.paginator;
    })
  }


  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

}
