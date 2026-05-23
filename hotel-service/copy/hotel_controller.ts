// @ts-ignore
import { Hono } from "hono";
// @ts-ignore
import * as hotelBooking from "./hotel_service.ts";
const app = new Hono();

app.post("/api/bookings", async (c) => {
  const token = c.req.header("Authorization");
  const bookingRequest = await c.req.json();
  await hotelBooking.book(bookingRequest,token);
  return c.text("Successful booking");
});

app.get("/api/search/hotels", async (c) => {
  const city = c.req.query("city");
  const result = await hotelBooking.searchHotels(city);
  return c.json(result);
});

// @ts-ignore
Deno.serve({ port: 8000 }, app.fetch);
