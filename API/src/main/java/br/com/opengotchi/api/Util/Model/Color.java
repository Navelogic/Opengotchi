package br.com.opengotchi.api.Util.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Size(min = 1, max = 255, message = "Color name must be between 1 and 255 characters")
    @Column(nullable = false, updatable = false)
    private String name;

    @Pattern(regexp = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$", message = "Hex color code must be valid (e.g., #RRGGBB or #RGB)")
    @Column(nullable = false, updatable = false)
    private String hex;

    @Override
    public String toString() {
        return String.format("Color{name='%s', hex='%s'}", name, hex);
    }
}
