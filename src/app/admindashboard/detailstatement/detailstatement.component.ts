import { Component, OnInit } from '@angular/core';
import { AdmindashboardService } from '../admindashboard.service';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
@Component({
  selector: 'app-detailstatement',
  templateUrl: './detailstatement.component.html',
  styleUrls: ['./detailstatement.component.css']
})
export class DetailstatementComponent implements OnInit {

  data : FormGroup
  transaction : {}
  constructor(private admindashboardService: AdmindashboardService,private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.data = this.formBuilder.group({
      ac: ['', Validators.required,],
     
    })
  }

    getallcustomertransaction(){
      console.log(this.data.value)
  
      this.admindashboardService.allcustomertransaction(this.data.value.ac).subscribe( res => {
        this.transaction = res;
        console.log(this.transaction);
      }, 
        error =>{console.log(error);
        } 
      );
  
      
   }
}
