package com.example.auth;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/ms1")
public class AuthController {
 @PostMapping(value="/signin", consumes="application/json", produces="application/json")
 public ResponseEntity<Map<String,String>> signIn(@RequestBody SignInRequest request) {
  if(request.getUsername()==null || request.getUsername().isBlank() || request.getPassword()==null || request.getPassword().isBlank())
   return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message","Invalid credentials"));
  // Demo-only JWT-shaped value; not a signed production JWT.
  String header=encode("{\"alg\":\"none\",\"typ\":\"JWT\"}");
  String payload=encode("{\"sub\":\"" + request.getUsername() + "\",\"nonce\":\"" + UUID.randomUUID() + "\"}");
  String token=header+"."+payload+"."+encode(UUID.randomUUID().toString());
  return ResponseEntity.ok(Map.of("token",token));
 }
 private String encode(String s){ return Base64.getUrlEncoder().withoutPadding().encodeToString(s.getBytes(StandardCharsets.UTF_8)); }
}
