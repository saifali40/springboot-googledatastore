package com.scheduling.j11.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Book")
public class Books {
    @Id
    private String id;

    private String brand;

    private String merchantId;

    private String referrerId;

    private String referrerType; // MERCHANT - STAFF - LOCATION - CALENDAR

    private String title;

    private String originalTitle;
}
