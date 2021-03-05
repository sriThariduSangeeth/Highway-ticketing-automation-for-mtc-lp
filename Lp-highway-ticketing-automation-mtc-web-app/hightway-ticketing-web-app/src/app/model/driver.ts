export class Driver {

    private driverName: string;
    private driverNIC:string;
    private driverEmail:string;
    private driverAddress:string;
    private driverBloodGroup:string;
    private driverGender :string;
    private driverLicenceId :string;
    private password :string;
    

    constructor(driverName :string, driverNIC:string,  driverEmail:string, driverAddress:string, driverBloodGroup:string, driverGender:string, driverLicenceId:string, password:string){
        this.driverName = driverName;
        this.driverNIC = driverNIC;
        this.driverEmail = driverEmail;
        this.driverAddress = driverAddress;
        this.driverBloodGroup = driverBloodGroup;
        this.driverGender = driverGender;
        this.driverLicenceId = driverLicenceId;
        this.password = password;
    }
    
    
}