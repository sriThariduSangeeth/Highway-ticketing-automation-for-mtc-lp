package com.sangeeth.hta.lphtavehicleservice.services;


import com.google.api.services.drive.model.File;

/**
 * @author dtsangeeth
 * @created 12 / 02 / 2021
 * @project lp-hta-vehicle-service
 */
public interface GoogleDriveService {

    File upLoadFile(String fileName, String filePath, String mimeType);
}
