import { LiveAnnouncer } from '@angular/cdk/a11y';
import { AfterViewInit, Component, OnInit, ViewChild, ViewEncapsulation } from '@angular/core';
import { MatSort, Sort, MatSortModule } from '@angular/material/sort';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { fuseAnimations } from '@fuse/animations';
import { UnidadeService } from '../unidade.service';
import { Unidade } from 'app/models/unidade';

@Component({
  selector: 'app-unidade-list',
  templateUrl: './unidade-list.component.html',
  encapsulation: ViewEncapsulation.None,
  animations: fuseAnimations
})
export class UnidadeListComponent implements OnInit {

  ELEMENT_DATA: Unidade[] = []


  displayedColumns: string[] = ['cnes', 'nome', 'gestao', 'acoes'];
  dataSource = new MatTableDataSource<Unidade>(this.ELEMENT_DATA);

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private service: UnidadeService) { }
  ngOnInit(): void {
    this.findAll();
  }

  findAll() {
    this.service.findAll().subscribe(resposta => {
      console.log(resposta);
      this.ELEMENT_DATA = resposta
      this.dataSource = new MatTableDataSource<Unidade>(this.ELEMENT_DATA);
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

