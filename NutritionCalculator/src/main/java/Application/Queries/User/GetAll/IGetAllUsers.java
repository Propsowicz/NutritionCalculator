package Application.Queries.User.GetAll;

import Application.BuildingBlocks.Primitives.PaginatedResponse;
import Application.Queries.User.DtoModels.ApplicationUserDto;
import Presentation.BuidlingBlocks.Primitives.PaginatedRequest;

public interface IGetAllUsers {
    PaginatedResponse<ApplicationUserDto> Handle(PaginatedRequest request);
}
