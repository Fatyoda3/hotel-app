// @ts-ignore
import { Hono } from "hono";
// @ts-ignore
import * as hotelBooking from "./hotel_service.ts";
const app = new Hono();

app.post("/api/bookings", async (c) => {
  const token = c.req.header("Authorization");

  const bookingRequest = await c.req.json();
  const body = JSON.stringify({
    rooms: bookingRequest.rooms,
    hotelId: bookingRequest.hotel_id,
  });

  await hotelBooking.book(bookingRequest);

  await fetch("http:localhost:3000/talk", {
    method: "POST",
    body,
    headers: {
      "Content-Type": "application/json",
      Authorization: token,
    },
  });

  return c.text("Successful booking");
});

app.get("/api/search/hotels", async (c) => {
  const f = c.req.query("city");

  const result = await hotelBooking.searchHotels(f);
  return c.json(result);
});

// @ts-ignore
Deno.serve({ port: 8000 }, app.fetch);
