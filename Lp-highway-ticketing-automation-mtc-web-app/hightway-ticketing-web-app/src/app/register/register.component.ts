import { Component ,ViewChild, ElementRef  } from '@angular/core';
import { HttpClient, HttpEventType } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { FileUploadService } from '../services/file-upload.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {


  constructor(private fileUploadService: FileUploadService) {}

  // selectedFile!: File;
  retrievedImage: any;
  // base64Data: any;
  // retrieveResonse: any;
  message: string | any;
  imageName: any;
  fileName!:string;
  file! : File;
  files: File[] = [];

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
    const formData = new FormData();  
    formData.append('file', file); 
    this.fileUploadService.upload(formData).subscribe(
       rsp => {
        console.log(rsp.type)
        this.message = 'Image uploaded successfully';
        },
        error => {
            console.log(error)
        });
  
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
