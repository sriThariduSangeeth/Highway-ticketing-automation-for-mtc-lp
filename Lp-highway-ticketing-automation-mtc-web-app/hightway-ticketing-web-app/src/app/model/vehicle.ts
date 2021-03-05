export class Vehicle {
    vehicleId: string;
    vehicleBrand: string;
    vehicleColor: string;
    vehicleCategory: string;
    manifestYear: number;

    constructor(vehicleId: string,
        vehicleBrand: string,
        vehicleColor: string,
        vehicleCategory: string,
        manifestYear: number) {

            this.vehicleId = vehicleId;
            this.vehicleBrand = vehicleBrand;
            this.vehicleColor = vehicleColor;
            this.vehicleCategory = vehicleCategory;
            this.manifestYear = manifestYear;
    }
}