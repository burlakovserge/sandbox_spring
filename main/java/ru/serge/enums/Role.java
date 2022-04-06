package ru.serge.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
@Getter
public enum Role implements GrantedAuthority {
    ADMIN("ADMIN"),
    USER("REGULAR_USER");

    private final String description;

    @Override
    public String getAuthority() {
        return this.description;
    }
}
