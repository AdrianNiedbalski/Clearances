import java.util.List;

public record CustomsDto(
        Integer id,
        String  customsType,
        Integer exporterId,
        Integer importerId,
        Integer employeeId,
        String  transportLocation,
        List<Integer> cargoIds,
        Integer customsOfficeId,
        String  status
) {}