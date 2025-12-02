package com.websec_exam_backend.crew_member;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrewMemberService {

    CrewMemberRepository crewMemberRepository;

    public CrewMemberService(CrewMemberRepository crewMemberRepository) {
        this.crewMemberRepository = crewMemberRepository;
    }

    public List<CrewMemberDTO> getAllCrewMembers() {
        return crewMemberRepository.findAll().stream().map(
                crewMember -> new CrewMemberDTO(
                        String.valueOf(crewMember.getId()),
                        crewMember.getName(),
                        crewMember.getEmail()
                )
        ).toList();
    }

    public List<CrewMemberDTO> getFilteredCrewMembers(List<JsonObject> crewMembers) {
        System.out.println("Filters: " + crewMembers);
        List<CrewMemberDTO> crewMemberList = getAllCrewMembers();

        for(JsonObject filter : crewMembers) {
            JsonObject field = filter.getAsJsonObject("field");
            JsonObject value = filter.getAsJsonObject("value");

            if(field != null && value != null) {
                String fieldStr = field.getAsString();
                String valueStr = value.getAsString();
                System.out.println("Field: " + fieldStr + ", Value: " + valueStr);
                if(fieldStr.equals("id")) {
                    crewMemberList = crewMemberList.stream()
                            .filter(crewMember -> crewMember.id().equalsIgnoreCase(valueStr))
                            .toList();
                }
                if (fieldStr.equals("name")) {
                    crewMemberList = crewMemberList.stream()
                            .filter(crewMember -> crewMember.name().equalsIgnoreCase(valueStr))
                            .toList();
                }
                if (fieldStr.equals("email")) {
                    crewMemberList = crewMemberList.stream()
                            .filter(crewMember -> crewMember.email().equalsIgnoreCase(valueStr))
                            .toList();
                }
            }
        }

        return crewMemberList;
    }
}
