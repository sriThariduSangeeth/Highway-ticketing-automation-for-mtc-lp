import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { FileUploadService } from 'src/app/services/file-upload.service';

@Component({
  selector: 'app-vehicleadd',
  templateUrl: './vehicleadd.component.html',
  styleUrls: ['./vehicleadd.component.css']
})
export class VehicleaddComponent implements OnInit {

  registermode:any = "Vehicle Register Page";
  url:string = "../../../assets/upload.svg";
  retrievedImage: any;
  // base64Data: any;
  // retrieveResonse: any;
  num:number = 1;
  message: string | any;
  imageName: any;
  fileName!:string;
  file! : File;
  files: File[] = [];

  loginForm!: FormGroup;
  emailRegx = /^(([^<>+()\[\]\\.,;:\s@"-#$%&=]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,3}))$/;
  

  constructor(private fileUploadService: FileUploadService , private formBuilder: FormBuilder) { }

  ngOnInit(): void {
  }

  submit(){
    this.num = this.num + 1;
  };
 
  @ViewChild("fileUpload", { static: false })
  fileUpload!: ElementRef;

  //Gets called when the user selects an image
  public onFileChanged(event : any) {
    //Select File
    this.file = event.target.files[0];
  }

  //Gets called when the user clicks on submit to upload the image
  onUpload() {
    console.log(this.files)
    this.fileUpload.nativeElement.value = '';
    this.uploadFile(this.file); 
  }

  uploadFile(file: File) {  
    // const formData = new FormData();  
    // formData.append('file', file); 
    // this.fileUploadService.upload(formData).subscribe(
    //    rsp => {
    //     console.log(rsp.type)
    //     this.message = 'Image uploaded successfully';
    //     },
    //     error => {
    //         console.log(error)
    //     });
  
    }
}
