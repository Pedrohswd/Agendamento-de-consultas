import { animate, animation } from '@angular/animations';
import { Component, OnInit, ViewChild, ViewEncapsulation } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { fuseAnimations } from '@fuse/animations';
import { Medico } from 'app/models/medico';
import { MedicoService } from '../medico.service';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-medico-list',
  templateUrl: './medico-list.component.html',
  encapsulation: ViewEncapsulation.None,
  animations: fuseAnimations
})

export class MedicoListComponent implements OnInit {
  ELEMNT_DATA: Medico[] = []

  displayedColumns: string[] = ['crm', 'nome', 'dt_nascimento', 'acoes'];
  dataSource = new MatTableDataSource<Medico>(this.ELEMNT_DATA);

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private service: MedicoService) { }

  ngOnInit(): void {
    this.findAll();
  }
  findAll() {
    this.service.findAll().subscribe(res => {
      this.ELEMNT_DATA = res;
      this.dataSource = new MatTableDataSource<Medico>(this.ELEMNT_DATA);
      this.dataSource.paginator = this.paginator;
      console.log(res);
    })
  }
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }
  applyFilter(e: Event) {
    const filterValue = (e.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }


}
