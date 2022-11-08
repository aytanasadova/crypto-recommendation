package xm.cryptorecommendation.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xm.cryptorecommendation.service.CryptoDataService;

import java.time.LocalDate;

@Tag(name = "crypto-data")
@RestController
@RequestMapping("/crypto-data/")
public class CryptoDataController {

    private final CryptoDataService cryptoDataService;

    public CryptoDataController(CryptoDataService cryptoDataService) {
        this.cryptoDataService = cryptoDataService;
    }

    @Operation(summary = "Oldest price for each crypto for the whole month", tags = "crypto-data")
    @GetMapping("/withOldestPrice/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> listAllWithOldestPrice() {
        return cryptoDataService.listAllWithOldestPrice();
    }

    @Operation(summary = "Newest price for each crypto for the whole month", tags = "crypto-data")
    @GetMapping("/withNewestPrice/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> listAllWithNewestPrice() {
        return cryptoDataService.listAllWithNewestPrice();
    }

    @Operation(summary = "Min price for each crypto for the whole month", tags = "crypto-data")
    @GetMapping("/withMinPrice/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> listAllWithMinPrice() {
        return cryptoDataService.listAllWithMinPrice();
    }

    @Operation(summary = "Max price for each crypto for the whole month", tags = "crypto-data")
    @GetMapping("/withMaxPrice/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> listAllWithMaxPrice() {
        return cryptoDataService.listAllWithMaxPrice();
    }


    @Operation(summary = "descending sorted list of all the cryptos,comparing the normalized range (i.e. (max-min)/min)", tags = "crypto-data")
    @GetMapping("/withNormalizedPrice/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> listAllWithNormalizedPrice() {
        return cryptoDataService.listAllWithNormalizedPrice();
    }


    @Operation(summary = "Min price for a requested crypto", tags = "crypto-data")
    @GetMapping("/minPriceByCryptoName/{name}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> getMinPriceByCryptoName(@RequestParam String name) {
        return cryptoDataService.getMinPriceByCryptoName(name);
    }

    @Operation(summary = "Max price for a requested crypto", tags = "crypto-data")
    @GetMapping("/maxPriceByCryptoName/{name}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> getMaxPriceByCryptoName(@RequestParam String name) {
        return cryptoDataService.getMaxPriceByCryptoName(name);
    }

    @Operation(summary = "Oldest price for a requested crypto", tags = "crypto-data")
    @GetMapping("/oldestPriceByCryptoName/{name}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> getOldestPriceByCryptoName(@RequestParam String name) {
        return cryptoDataService.getOldestPriceByCryptoName(name);
    }

    @Operation(summary = "Newest price for a requested crypto", tags = "crypto-data")
    @GetMapping("/newestPriceByCryptoName/{name}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> getNewestPriceByCryptoName(@RequestParam String name) {
        return cryptoDataService.getNewestPriceByCryptoName(name);
    }

    @Operation(summary = "The crypto with the highest normalized range for a specific day", description = "2022-01-22", tags = "crypto-data")
    @GetMapping("/byMaxNormalizedPrice/date/{date}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> getByMaxNormalizedPriceByDate(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam LocalDate date) {
        return cryptoDataService.getByMaxNormalizedPriceByDate(date);
    }


}
