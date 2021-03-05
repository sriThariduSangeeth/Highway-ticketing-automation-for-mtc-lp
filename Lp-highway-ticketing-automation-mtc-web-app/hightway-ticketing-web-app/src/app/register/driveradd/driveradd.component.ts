import { ChangeDetectionStrategy, Component, ViewChild, ElementRef, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FileUploadService } from '../../services/file-upload.service';
import { ActivatedRoute } from '@angular/router';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { FileUploader } from 'ng2-file-upload';
import { AcceptValidator, MaxSizeValidator } from '@angular-material-components/file-input';
import { Driver } from 'src/app/model/driver';

@Component({
  selector: 'app-driveradd',
  templateUrl: './driveradd.component.html',
  styleUrls: ['./driveradd.component.css']
})
export class DriveraddComponent implements OnInit {

  registermode: string = "Driver Register Page";
  typeOne: string | any;

  // selectedFile!: File;
  retrievedImage: any;
  // base64Data: any;
  // retrieveResonse: any;
  num: number = 1;
  message: string | any;
  imageName: any;
  fileName!: string;
  file!: File;
  files: File[] = [];
  url: string | any = "../../../assets/upload.svg";

  dname = '';
  daddress = '';
  dgender = '';
  dlicense = '';
  dnic = '';
  dtelnumber = '';
  demail = '';
  dblood = '';
  dpassword = '';
  drepassword = '';
  dimage!: FormData;


  loginForm!: FormGroup;
  emailRegx = /^(([^<>+()\[\]\\.,;:\s@"-#$%&=]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,3}))$/;

  constructor(private fileUploadService: FileUploadService, private router: ActivatedRoute, private formBuilder: FormBuilder) {}
  ngOnInit(): void {}

  changeVal() {

    let type: string = this.router.snapshot.params.type;

    if (type == 'vehicle') {
      this.registermode = "Vehicle Register Page";
      console.log(this.registermode);
    } else {
      this.registermode = "Driver Register Page";
      console.log(this.registermode);
    }
  }

  submit() {
    if (this.file != null) {
      const formData = new FormData();
      formData.append('profileImg', this.file , this.file.name);
      let driver = new Driver(this.dname,this.dnic,this.demail,this.daddress,this.dblood,this.dgender,this.dlicense,this.dpassword);
      formData.append('driver', JSON.stringify(driver));
      this.fileUploadService.upload(formData).subscribe(
        rsp => {
          console.log(rsp.type)
          this.message = 'Image uploaded successfully';
        },
        error => {
          console.log(error)
        });
    }
  };

  @ViewChild("fileUpload", { static: false })
  fileUpload!: ElementRef;

  //Gets called when the user selects an image
  public onFileChanged(event: any) {
    //Select File
    if (event.target.files.length != 0) {
      this.file = event.target.files[0];
      const reader = new FileReader();
      reader.onload = (e: any) => {
        this.url = reader.result;
      };
      reader.readAsDataURL(this.file);
    }

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
    //   rsp => {
    //     console.log(rsp.type)
    //     this.message = 'Image uploaded successfully';
    //   },
    //   error => {
    //     console.log(error)
    //   });
  }


  //Gets called when the user clicks on retieve image button to get the image from back end
  getImage() {
    //Make a call to Sprinf Boot to get the Image Bytes.
    // this.httpClient.get('http://localhost:8080/image/get/' + this.imageName)
    //   .subscribe(
    //     res => {
    //       this.retrieveResonse = res;
    //       this.base64Data = this.retrieveResonse.picByte;
    //       this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
    //     }
    //   );
  }
}
