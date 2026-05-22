// @ts-ignore
import { MongoClient } from "mongodb";

const client = new MongoClient("mongodb://127.0.0.1:27017");
// @ts-ignore
await client.connect();
const db = client.db("test");
const hotelRepository = db.collection("hotel");

export async function getHotelsByCity(city: string) {
  const result = await hotelRepository.find({ city }).toArray();

  return result.map(({ name, availableRooms, city, _id }) => ({
    name,
    availableRooms,
    city,
    id: _id,
  }));
}

export async function getHotelsByHotelId(hotelId: number) {
  const hotel = await hotelRepository.findOne({ hotelId });
  return hotel;
}

// @ts-ignore
export async function updateAvailableRoomsByHotelId(
  hotelId: number,
  updatedRooms: number,
) {
  await hotelRepository.updateOne(
    { hotelId },
    { $set: { availableRooms: updatedRooms } },
  );
}
