package com.Shop.Ecommerce.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="users")
public class User implements UserDetails {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String firstname;
   private String lastname;
   private String email;
   private Date dob;
   private String region;
   private String password;
   private Boolean isAdmin = false;

   private LocalDate createdDate;

   @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
   private List<Address> address = new ArrayList<>();

   @Embedded
   @ElementCollection
   @CollectionTable(name="payment_information",joinColumns = @JoinColumn(name = "user_id"))
   private List<PaymentInformation> paymentInformations = new ArrayList<>();

   @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
   @JsonIgnore
   private List<Rating> ratings = new ArrayList<>();

   @JsonIgnore
   @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
   private List<Review> reviews = new ArrayList<>();

   @JsonIgnore
   @Enumerated(EnumType.STRING)
   private Role role;

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return List.of(new SimpleGrantedAuthority(role.name()));
   }

   @Override
   public String getPassword() {
      return password;
   }

   @Override
   public String getUsername() {
      return email;
   }

   @Override
   public boolean isAccountNonExpired() {
      return true;
   }

   @Override
   public boolean isAccountNonLocked() {
      return true;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }

   @Override
   public boolean isEnabled() {
      return true;
   }
}
