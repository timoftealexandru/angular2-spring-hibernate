package ro.ubb.catalog.web.dto;

import ro.ubb.catalog.core.model.Client;

import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


/**
 * Created by paul on 4/9/2017.
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientsDto {
    private Set<ClientDto> clients;
}

