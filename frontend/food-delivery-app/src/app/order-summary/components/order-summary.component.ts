import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderService } from '../service/order.service';
import { OrderDTO } from '../models/OrderDTO';

@Component({
  selector: 'app-order-summary',
  standalone: false,
  templateUrl: './order-summary.component.html',
  styleUrl: './order-summary.component.css'
})
export class OrderSummaryComponent {

  orderSummary?: OrderDTO;
  obj?: any;
  total: number = 0;
  showDialog: boolean = false; 

  constructor(private route: ActivatedRoute, private orderService: OrderService, private router: Router) { }

  ngOnInit() {
    const data = this.route.snapshot.queryParams['data'];
    if (data) {
      const parsedData = JSON.parse(data);
      
      this.obj = {
        userId: 1,
        restaurant: parsedData.restaurant,
        foodItemList: parsedData.foodItemsList || parsedData.foodItemList || []
      };
      
      this.orderSummary = this.obj;

      this.total = this.obj.foodItemList.reduce((accumulator: number, currentValue: any) => {
        return accumulator + (currentValue.price * currentValue.quantity);
      }, 0);
    }
  }

  placeOrder() {
    this.orderService.addOrder(this.orderSummary).subscribe({
      next: (response) => {
        this.showDialog = true;
      },
      error: (error) => {
        console.error('Failed to Save Data.', error);
      }
    });
  }

  closeDialog() {
    this.showDialog = false;
    this.router.navigate(['/']);
  }
}
