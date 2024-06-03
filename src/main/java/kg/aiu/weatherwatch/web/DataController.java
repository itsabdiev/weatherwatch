package kg.aiu.weatherwatch.web;


import kg.aiu.weatherwatch.dto.request.DataRequest;
import kg.aiu.weatherwatch.dto.response.DataResponse;
import kg.aiu.weatherwatch.dto.response.MessageResponse;
import kg.aiu.weatherwatch.endpoint.DataEndpoint;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/datas")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class DataController {

    DataEndpoint dataEndpoint;

    @GetMapping
    public List<DataResponse> getAll() {
        return dataEndpoint.getAll();
    }

    @GetMapping("/{id}")
    public DataResponse getById(@PathVariable Long id) {
        return dataEndpoint.getById(id);
    }

    @PostMapping
    public MessageResponse save(@RequestBody DataRequest dataRequest) {
        return dataEndpoint.save(dataRequest);
    }

    @PutMapping("/{id}")
    public MessageResponse update(@RequestBody DataRequest dataRequest, @PathVariable Long id) {
        return dataEndpoint.update(id,dataRequest);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        return dataEndpoint.delete(id);
    }
}
