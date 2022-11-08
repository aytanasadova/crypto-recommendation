package xm.cryptorecommendation.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xm.cryptorecommendation.service.CryptoDataService;

@Tag(name="crypto-data")
@RestController
@RequestMapping("/crypto-data/")
public class CryptoDataController {

    @Autowired
    private CryptoDataService cryptoDataService;

    @Operation(summary = "List of oldest price for each crypto for the whole month", tags = "crypto-data")
    @GetMapping("/listAllWithOldestPrice/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> listAllWithOldestPrice() {
        return cryptoDataService.listAllWithOldestPrice();
    }

    @Operation(summary = "List of newest price for each crypto for the whole month", tags = "crypto-data")
    @GetMapping("/listAllWithNewestPrice/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> listAllWithNewestPrice() {
        return cryptoDataService.listAllWithNewestPrice();
    }
    @Operation(summary = "List of min price for each crypto for the whole month", tags = "crypto-data")
    @GetMapping("/listAllWithMinPrice/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> listAllWithMinPrice() {
        return cryptoDataService.listAllWithMinPrice();
    }
    @Operation(summary = "List of max price for each crypto for the whole month", tags = "crypto-data")
    @GetMapping("/listAllWithMaxPrice/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> listAllWithMaxPrice() {
        return cryptoDataService.listAllWithMaxPrice();
    }
}
