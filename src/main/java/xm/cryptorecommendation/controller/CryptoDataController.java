package xm.cryptorecommendation.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xm.cryptorecommendation.service.CryptoDataService;

import java.time.LocalDate;


/**
 * Class contains methods with and without interval search
 * @author Aytan Asadova
 * @version 1.0
 * @since 2022-11-08
 */
@Tag(name = "crypto-data")
@RestController
@RequestMapping("/crypto-data/")
public class CryptoDataController {

    private final CryptoDataService cryptoDataService;

    public CryptoDataController(CryptoDataService cryptoDataService) {
        this.cryptoDataService = cryptoDataService;
    }

    @Operation(summary = "Oldest price for each crypto for the whole data", tags = "crypto-data")
    @GetMapping("/withOldestPrice/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> listAllWithOldestPrice() {
        return cryptoDataService.listAllWithOldestPrice();
    }

    @Operation(summary = "Oldest price for each crypto for the interval", tags = "crypto-data")
    @GetMapping("/withOldestPrice/{beginInterval}/{endInterval}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> listAllWithOldestPrice(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate beginInterval,
                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate endInterval) {
        return cryptoDataService.listAllWithOldestPrice(beginInterval,endInterval);
    }

    @Operation(summary = "Newest price for each crypto for the whole month", tags = "crypto-data")
    @GetMapping("/withNewestPrice/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> listAllWithNewestPrice() {
        return cryptoDataService.listAllWithNewestPrice();
    }

    @Operation(summary = "Newest price for each crypto for the interval", tags = "crypto-data")
    @GetMapping("/withNewestPrice/{beginInterval}/{endInterval}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> listAllWithNewestPrice(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate beginInterval,
                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate endInterval) {
        return cryptoDataService.listAllWithNewestPrice(beginInterval,endInterval);
    }


    @Operation(summary = "Min price for each crypto for the interval", tags = "crypto-data")
    @GetMapping("/withMinPrice/{beginInterval}/{endInterval}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> listAllWithMinPrice(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate beginInterval,
                                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate endInterval) {
        return cryptoDataService.listAllWithMinPrice(beginInterval,endInterval);
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

    @Operation(summary = "Max price for each crypto for  interval", tags = "crypto-data")
    @GetMapping("/withMaxPrice/{beginInterval}/{endInterval}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> listAllWithMaxPrice(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate beginInterval,
                                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate endInterval) {
        return cryptoDataService.listAllWithMaxPrice(beginInterval,endInterval);
    }


    @Operation(summary = "Descending sorted list of all the cryptos,comparing the normalized range (i.e. (max-min)/min)", tags = "crypto-data")
    @GetMapping("/withNormalizedPrice/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> listAllWithNormalizedPrice() {
        return cryptoDataService.listAllWithNormalizedPrice();
    }

    @Operation(summary = "Descending sorted list of all the cryptos,comparing the normalized range (i.e. (max-min)/min) for the interval", tags = "crypto-data")
    @GetMapping("/withNormalizedPrice/{beginInterval}/{endInterval}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> listAllWithNormalizedPrice(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate beginInterval,
                                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate endInterval) {
        return cryptoDataService.listAllWithNormalizedPrice(beginInterval,endInterval);
    }


    @Operation(summary = "Min price for a requested crypto", tags = "crypto-data")
    @GetMapping("/minPriceByCryptoName/{name}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> getMinPriceByCryptoName(@PathVariable String name) {
        return cryptoDataService.getMinPriceByCryptoName(name);
    }
    @Operation(summary = "Min price for a requested crypto for the interval", tags = "crypto-data")
    @GetMapping("/minPriceByCryptoName/{name}/{beginInterval}/{endInterval}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> getMinPriceByCryptoName(@PathVariable String name,
                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate beginInterval,
                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate endInterval) {
        return cryptoDataService.getMinPriceByCryptoName(name,beginInterval,endInterval);
    }

    @Operation(summary = "Max price for a requested crypto", tags = "crypto-data")
    @GetMapping("/maxPriceByCryptoName/{name}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> getMaxPriceByCryptoName(@PathVariable String name) {
        return cryptoDataService.getMaxPriceByCryptoName(name);
    }
    @Operation(summary = "Max price for a requested crypto for the interval", tags = "crypto-data")
    @GetMapping("/maxPriceByCryptoName/{name}/{beginInterval}/{endInterval}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> getMaxPriceByCryptoName(@PathVariable String name,
                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate beginInterval,
                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate endInterval) {
        return cryptoDataService.getMaxPriceByCryptoName(name,beginInterval,endInterval);
    }
    @Operation(summary = "Oldest price for a requested crypto", tags = "crypto-data")
    @GetMapping("/oldestPriceByCryptoName/{name}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> getOldestPriceByCryptoName(@PathVariable String name) {
        return cryptoDataService.getOldestPriceByCryptoName(name);
    }
    @Operation(summary = "Oldest price for a requested crypto for the interval", tags = "crypto-data")
    @GetMapping("/oldestPriceByCryptoName/{name}/{beginInterval}/{endInterval}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> getOldestPriceByCryptoName(@PathVariable String name,
                                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate beginInterval,
                                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate endInterval) {
        return cryptoDataService.getOldestPriceByCryptoName(name,beginInterval,endInterval);
    }

    @Operation(summary = "Newest price for a requested crypto", tags = "crypto-data")
    @GetMapping("/newestPriceByCryptoName/{name}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> getNewestPriceByCryptoName(@PathVariable String name) {
        return cryptoDataService.getNewestPriceByCryptoName(name);
    }
    @Operation(summary = "Newest price for a requested crypto for the interval", tags = "crypto-data")
    @GetMapping("/newestPriceByCryptoName/{name}/{beginInterval}/{endInterval}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> getNewestPriceByCryptoName(@PathVariable String name,
                                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate beginInterval,
                                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate endInterval) {
        return cryptoDataService.getNewestPriceByCryptoName(name,beginInterval,endInterval);
    }
    @Operation(summary = "The crypto with the highest normalized range for a specific day", description = "2022-01-22", tags = "crypto-data")
    @GetMapping("/byMaxNormalizedPrice/date/{date}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "204", description = "No Content!")})
    public ResponseEntity<?> getByMaxNormalizedPriceByDate(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate date) {
        return cryptoDataService.getByMaxNormalizedPriceByDate(date);
    }


}
