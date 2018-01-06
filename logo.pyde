size(400, 400)
background(255, 255, 255)

grey   = color(80, 80, 80)
white  = color(255, 255, 255)
yellow = color(255,253, 225)

stroke(grey, 50) 

# step has to be odd and weird to make divisions not regular
step = 33

# make 6 tours of drawing for good enought density effect 
for _ in range(6):
    
    # start at -with to prevent visual gaps at the top 
    for i in range(-width, (width * height) / step):
        x = (i * step) % width
        y = (i * step) / width
        
        # this couldn't have been more arbitrary...
        m = random(0, 4)

        # for 20% of cases fill triangles with pale yellow
        # for fun and eye pleasure
        if random(0, 10) > 8:
            fill(yellow, 40 - (10 * m)) 
        else:
            fill(white,  40 - (10 * m))
            
        # just some more or less random triangles
        triangle(x + random(-8 * m,    -3),  # left bottom corner
                 y + random(     3, 8 * m),
                 x + random(-4 * m, 4 * m),  # top corner
                 y + random(-8 * m,    -3), 
                 x + random(     3, 8 * m),  # right bottom corner
                 y + random(     3, 8 * m))

save('logo.png')