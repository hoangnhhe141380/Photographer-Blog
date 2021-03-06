create database [Photographer]
USE [Photographer]
GO
/****** Object:  Table [dbo].[Gallery]    Script Date: 06/29/2021 11:59:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Gallery](
	[id] [int] NOT NULL,
	[name] [nvarchar](50) NULL,
	[description] [nvarchar](max) NULL,
	[image] [nvarchar](50) NULL,
 CONSTRAINT [PK_Gallery] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[Gallery] ([id], [name], [description], [image]) VALUES (1, N'Gallery 1', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation', N'anh1.jpg')
INSERT [dbo].[Gallery] ([id], [name], [description], [image]) VALUES (2, N'Gallery 2', N'Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar. The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild Question Marks and devious Semikoli, but the Little Blind Text didn’t listen.', N'anh2.jpg')
INSERT [dbo].[Gallery] ([id], [name], [description], [image]) VALUES (3, N'Gallery 3', N'A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents. I should be incapable of drawing a single stroke at the present moment; and yet I feel that I never was a greater artist than now. When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary.', N'anh3.jpg')
INSERT [dbo].[Gallery] ([id], [name], [description], [image]) VALUES (4, N'Gallery 4', N'One morning, when Gregor Samsa woke from troubled dreams, he found himself transformed in his bed into a horrible vermin. He lay on his armour-like back, and if he lifted his head a little he could see his brown belly, slightly domed and divided by arches into stiff sections. The bedding was hardly able to cover it and seemed ready to slide off any moment. His many legs, pitifully thin compared with the size of the rest of him, waved about helplessly as he looked. "What''s happened to me?" he thought. It wasn''t a dream. His room, a proper human room although a little too small, lay peacefully between its four familiar walls.', N'anh3.jpg')
INSERT [dbo].[Gallery] ([id], [name], [description], [image]) VALUES (5, N'Gallery 5', N'The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph, for quick jigs vex! Fox nymphs grab quick-jived waltz. Brick quiz whangs jumpy veldt fox. Bright vixens jump; dozy fowl quack. Quick wafting zephyrs vex bold Jim. Quick zephyrs blow, vexing daft Jim. Sex-charged fop blew my junk TV quiz. How quickly daft jumping zebras vex. Two driven jocks help fax my big quiz. Quick, Baz, get my woven flax jodhpurs! "Now fax quiz Jack!" my brave ghost pled. Five quacking zephyrs jolt my wax bed. Flummoxed by job, kvetching W. zaps Iraq.', N'anh4.jpg')
/****** Object:  Table [dbo].[Share]    Script Date: 06/29/2021 11:59:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Share](
	[icon] [nvarchar](50) NULL,
	[social_network] [nvarchar](50) NOT NULL,
	[url] [nvarchar](max) NULL,
 CONSTRAINT [PK_Share] PRIMARY KEY CLUSTERED 
(
	[social_network] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[Share] ([icon], [social_network], [url]) VALUES (N'fb.png', N'Facebook', N'https://www.facebook.com/')
INSERT [dbo].[Share] ([icon], [social_network], [url]) VALUES (N'gg.png', N'Google+', N'https://www.google.com.vn/')
INSERT [dbo].[Share] ([icon], [social_network], [url]) VALUES (N'tw.png', N'Twitter', N'https://twitter.com/')
/****** Object:  Table [dbo].[Intro]    Script Date: 06/29/2021 11:59:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Intro](
	[image] [nvarchar](50) NULL,
	[entry] [nvarchar](max) NULL,
	[aboutme] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[Intro] ([image], [entry], [aboutme]) VALUES (N'anh0.jpg', N'But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness.', N'But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure? On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment.')
/****** Object:  Table [dbo].[Information]    Script Date: 06/29/2021 11:59:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Information](
	[address] [nvarchar](max) NULL,
	[city] [nvarchar](max) NULL,
	[country] [nvarchar](50) NULL,
	[tel] [nvarchar](50) NULL,
	[email] [nvarchar](max) NULL,
	[image] [nvarchar](50) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[Information] ([address], [city], [country], [tel], [email], [image]) VALUES (N'Km29 Dai Lo Thang Long - Thach Hoa - Thach That', N'Ha Noi', N'Viet Nam', N'0912345678', N'hoangnhhe141380@fpt.edu.vn', N'vt.png')
/****** Object:  Table [dbo].[ImageGallery]    Script Date: 06/29/2021 11:59:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ImageGallery](
	[image] [nvarchar](50) NOT NULL,
	[gallery_id] [int] NOT NULL,
 CONSTRAINT [PK_ImageGallery] PRIMARY KEY CLUSTERED 
(
	[image] ASC,
	[gallery_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh0.jpg', 2)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh0.jpg', 3)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh0.jpg', 4)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh1.jpg', 1)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh1.jpg', 3)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh1.jpg', 4)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh1.jpg', 5)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh10.jpg', 1)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh2.jpg', 1)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh2.jpg', 2)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh2.jpg', 4)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh3.jpg', 1)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh3.jpg', 2)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh3.jpg', 3)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh3.jpg', 4)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh4.jpg', 2)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh4.jpg', 3)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh4.jpg', 4)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh5.jpg', 1)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh5.jpg', 2)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh5.jpg', 4)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh6.jpg', 1)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh6.jpg', 2)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh6.jpg', 3)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh6.jpg', 4)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh7.jpg', 1)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh7.jpg', 2)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh7.jpg', 4)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh8.jpg', 1)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh8.jpg', 3)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh8.jpg', 5)
INSERT [dbo].[ImageGallery] ([image], [gallery_id]) VALUES (N'anh9.jpg', 1)
/****** Object:  ForeignKey [FK_ImageGallery_Gallery]    Script Date: 06/29/2021 11:59:52 ******/
ALTER TABLE [dbo].[ImageGallery]  WITH CHECK ADD  CONSTRAINT [FK_ImageGallery_Gallery] FOREIGN KEY([gallery_id])
REFERENCES [dbo].[Gallery] ([id])
GO
ALTER TABLE [dbo].[ImageGallery] CHECK CONSTRAINT [FK_ImageGallery_Gallery]
GO
