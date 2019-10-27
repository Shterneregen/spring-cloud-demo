package random.roomservices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/rooms")
@Api(value = "rooms", tags = {"rooms"})
@SwaggerDefinition(tags = {
        @Tag(name = "rooms", description = "Data service operations on rooms")
})
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    @ApiOperation(value = "Get All Rooms", notes = "Gets all rooms in the system", nickname = "getRooms")
    public List<Room> findAll(@RequestParam(name = "roomNumber", required = false) String roomNumber) {
        if (StringUtils.isNotEmpty(roomNumber)) {
            return Collections.singletonList(roomRepository.findByRoomNumber(roomNumber));
        }
        return (List<Room>) roomRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Get Room", notes = "Gets a single room based on its unique id", nickname = "getRoom")
    public Room findOne(@PathVariable("id") long id) {
        return roomRepository.findById(id).orElse(null);
    }
}
