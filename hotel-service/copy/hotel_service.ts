// @ts-ignore
import * as hotelRepo from "./hotel_repo.ts";

export function searchHotels(city = "") {
  return hotelRepo.getHotelsByCity(city);
}

export async function book(bookingRequest: { hotelId: number; rooms: number }) {
  const hotelId = bookingRequest.hotelId;
  const rooms = bookingRequest.rooms;
  const hotel = await hotelRepo.getHotelsByHotelId(hotelId);

  const updatedRooms = hotel!.availableRooms - rooms;
  hotelRepo.updateAvailableRoomsByHotelId(hotelId, updatedRooms);
}
