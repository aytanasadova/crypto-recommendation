package xm.cryptorecommendation.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xm.cryptorecommendation.domain.Crypto;
import xm.cryptorecommendation.service.CryptoDataService;
import xm.cryptorecommendation.service.CryptoDataServiceImp;

import java.time.LocalDate;

@RestController
@RequestMapping("/crypto-data/")
public class CryptoDataController {
@Autowired
    private CryptoDataService cryptoDataService;



    @Operation(summary = "Descending sorted list of all the cryptos,comparing the normalized range ", tags = "listCryptoData")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "404", description = "Not Found!")})
    @GetMapping("/")
    public ResponseEntity<?> listAllByNormalizedRange() {
        return new ResponseEntity<>(cryptoDataService.listAll(), HttpStatus.OK);
    }

    @Operation(summary = "Calculates min price for whole month ", tags = "getCryptoData")
    @GetMapping("/price-monthly/min/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "404", description = "Not Found!")})
    public ResponseEntity<?> getMinPriceForEachDuringMonth() {
        return null;
    }

//    @GetMapping("")
//    public ResponseEntity<?> getMaxPriceForEachDuringMonth() {
//        return null;
//    }
//
//    @GetMapping("")
//    public ResponseEntity<?> getNewestPriceForEachDuringMonth() {
//        return null;
//    }
//
//    @GetMapping("")
//    public ResponseEntity<?> getOldestPriceForEachDuringMonth() {
//        return null;
//    }
//
//    @GetMapping("")
//    public ResponseEntity<?> getMinPriceForEachDuringMonth(Crypto crypto) {
//        return null;
//    }
//
//    @GetMapping("")
//    public ResponseEntity<?> getMaxPriceForEachDuringMonth(Crypto crypto) {
//        return null;
//    }
//
//    @GetMapping("")
//    public ResponseEntity<?> getNewestPriceForEachDuringMonth(Crypto crypto) {
//        return null;
//    }
//
//    @GetMapping("")
//    public ResponseEntity<?> getOldestPriceForEachDuringMonth(Crypto crypto) {
//        return null;
//    }
//
//    @GetMapping("")
//    public ResponseEntity<?> getWithHighestNormalizedRangeByDate(LocalDate date) {
//        return null;
//    }

}
