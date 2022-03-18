import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { WarehouseService } from '../service/warehouse-service.service';
import { Warehouse } from '../model/warehouse';

@Component({
  selector: 'app-warehouse-form',
  templateUrl: './warehouse-form.component.html',
  styleUrls: ['./warehouse-form.component.css']
})
export class WarehouseFormComponent {

  warehouse: Warehouse;


  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private warehouseService: WarehouseService) {
    this.warehouse = new Warehouse();
  }

  onSubmit() {
    this.warehouseService.save(this.warehouse).subscribe(result => this.gotoWarehouseList());
  }

  gotoWarehouseList() {
    this.router.navigate(['/warehouse']);
  }
}
