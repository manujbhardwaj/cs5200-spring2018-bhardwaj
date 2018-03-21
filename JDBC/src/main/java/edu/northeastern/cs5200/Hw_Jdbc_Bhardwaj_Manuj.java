package edu.northeastern.cs5200;

import java.sql.Date;
import java.util.Collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.northeastern.cs5200.dao.address.AddressDao;
import edu.northeastern.cs5200.dao.developer.DeveloperDao;
import edu.northeastern.cs5200.dao.page.PageDao;
import edu.northeastern.cs5200.dao.pageWebsiteRole.PageWebsiteRoleDao;
import edu.northeastern.cs5200.dao.phone.PhoneDao;
import edu.northeastern.cs5200.dao.priviledge.PriviledgeDao;
import edu.northeastern.cs5200.dao.role.RoleDao;
import edu.northeastern.cs5200.dao.user.UserDao;
import edu.northeastern.cs5200.dao.website.WebsiteDao;
import edu.northeastern.cs5200.dao.widget.WidgetDao;
import edu.northeastern.cs5200.dao.widgetType.WidgetTypeDao;
import edu.northeastern.cs5200.models.address.Address;
import edu.northeastern.cs5200.models.page.Page;
import edu.northeastern.cs5200.models.pageWebsiteRole.PageWebsiteRole;
import edu.northeastern.cs5200.models.person.Developer;
import edu.northeastern.cs5200.models.person.User;
import edu.northeastern.cs5200.models.phone.Phone;
import edu.northeastern.cs5200.models.priviledge.Priviledge;
import edu.northeastern.cs5200.models.role.Role;
import edu.northeastern.cs5200.models.website.Website;
import edu.northeastern.cs5200.models.widget.HeadingWidget;
import edu.northeastern.cs5200.models.widget.HtmlWidget;
import edu.northeastern.cs5200.models.widget.ImageWidget;
import edu.northeastern.cs5200.models.widget.Widget;
import edu.northeastern.cs5200.models.widget.WidgetType;
import edu.northeastern.cs5200.models.widget.YoutubeWidget;

@SpringBootApplication
public class Hw_Jdbc_Bhardwaj_Manuj {
	private static UserDao userDao = UserDao.getInstance();
	private static DeveloperDao developerDao = DeveloperDao .getInstance();
	private static RoleDao roleDao = RoleDao.getInstance();
	private static WidgetTypeDao widgetTypeDao = WidgetTypeDao.getInstance();
	private static PriviledgeDao priviledgeDao = PriviledgeDao.getInstance();
	private static WebsiteDao websiteDao = WebsiteDao.getInstance();
	private static PageDao pageDao = PageDao.getInstance();
	private static WidgetDao widgetDao = WidgetDao.getInstance();
	private static AddressDao addressDao = AddressDao.getInstance();
	private static PageWebsiteRoleDao pageRoleDao = PageWebsiteRoleDao.getInstance();
	private static PhoneDao phoneDao = PhoneDao.getInstance();
	private static PageWebsiteRoleDao websiteRoleDao = PageWebsiteRoleDao.getInstance();
	
	public static void main(String[] args) {
		SpringApplication.run(Hw_Jdbc_Bhardwaj_Manuj.class, args);
		
		int insertDeveloper = insertDeveloper();
		System.out.println("Number of developers inserted: " + insertDeveloper);
		
		int insertUser = insertUser();
		System.out.println("Number of users inserted: " + insertUser);
		
		int insertRole = insertRole();
		System.out.println("Number of roles inserted: " + insertRole);
		
		int insertPriviledge = insertPriviledge();
		System.out.println("Number of priviledges inserted: " + insertPriviledge);
		
		int insertWebsite = insertWebsite();
		System.out.println("Number of websites inserted: " + insertWebsite);
		
		int insertWebsiteRole = insertWebsiteRole();
		System.out.println("Number of website roles inserted: " + insertWebsiteRole);
		
		int insertPage = insertPage();
		System.out.println("Number of pages inserted: " + insertPage);
		
		int insertPageRole = insertPageRole();
		System.out.println("Number of page roles inserted: " + insertPageRole);
		
		int insertWidgetType = insertWidgetType();
		System.out.println("Number of widgetTypes inserted: " + insertWidgetType);
		
		int insertWidget = insertWidget();
		System.out.println("Number of widgets inserted: " + insertWidget);

		int update1 = update1();
		System.out.println("Number of updates in update1: " + update1);
		
		int update2 = update2();
		System.out.println("Number of updates in update2: " + update2);
		
		int update3 = update3();
		System.out.println("Number of updates in update3: " + update3);
		
		int update4 = update4();
		System.out.println("Number of updates in update4: " + update4);
		
		int delete1 = delete1();
		System.out.println("Number of deletes in delete1: " + delete1);
		
		int delete2 = delete2();
		System.out.println("Number of deletes in delete2: " + delete2);
		
		int delete3 = delete3();
		System.out.println("Number of deletes in delete3: " + delete3);
		
		int delete4 = delete4();
		System.out.println("Number of deletes in delete4: " + delete4);
	}
	
	private static int insertUser(){
		int result = 0;	
		
		User dan = new User("Dan", "Martin", "dan", "dan", "dan@martin.com", "7654fda", false);
		User ed = new User("Ed", "Karaz", "ed", "ed", "ed@kar.com", "5678dfgh", true);
		
		result = result + userDao.createUser(dan);
		result = result + userDao.createUser(ed);
		
		return result;
	}
	
	private static int insertDeveloper(){
		int result = 0;
		
		Developer alice = new Developer("Alice", "Wonder", "alice", "alice", "alice@wonder.com", "4321rewq");
		Developer bob = new Developer("Bob", "Marley", "bob", "bob", "bob@marley.com", "5432trew");
		Developer charlie = new Developer("Charles", "Garcia", "charlie", "charlie", "chuch@garcia.com", "6543ytre");
		
		result = result + developerDao.createDeveloper(alice);
		result = result + developerDao.createDeveloper(bob);
		result = result + developerDao.createDeveloper(charlie);
		
		return result;
	}
	
	private static int insertRole() {
		int result = 0;
		
		Role admin = new Role("admin");
		Role editor = new Role("editor");
		Role owner = new Role("owner");
		Role reviewer = new Role("reviewer");
		Role writer = new Role("writer");
		
		result = result + roleDao.createRole(admin);
		result = result + roleDao.createRole(editor);
		result = result + roleDao.createRole(owner);
		result = result + roleDao.createRole(reviewer);
		result = result + roleDao.createRole(writer);
		
		return result;
	}
	
	private static int insertWidgetType() {
		int result = 0;
		
		WidgetType heading = new WidgetType("heading");
		WidgetType image = new WidgetType("image");
		WidgetType youtube = new WidgetType("youtube");
		WidgetType html = new WidgetType("html");
		
		result = result + widgetTypeDao.createWidgetType(heading);
		result = result + widgetTypeDao.createWidgetType(image);
		result = result + widgetTypeDao.createWidgetType(youtube);
		result = result + widgetTypeDao.createWidgetType(html);
		
		return result;
	}
	
	private static int insertPriviledge() {
		int result = 0;
		
		Priviledge create = new Priviledge("create");
		Priviledge delete = new Priviledge("delete");
		Priviledge read = new Priviledge("read");
		Priviledge update = new Priviledge("update");
		
		result = result + priviledgeDao.createPriviledge(create);
		result = result + priviledgeDao.createPriviledge(delete);
		result = result + priviledgeDao.createPriviledge(read);
		result = result + priviledgeDao.createPriviledge(update);
		
		return result;
	}
	
	private static int insertWebsite() {
		int result = 0;
		
		int aliceId = developerDao.findDeveloperByUsername("alice").getId();
		int bobId = developerDao.findDeveloperByUsername("bob").getId();
		int charlieId = developerDao.findDeveloperByUsername("charlie").getId();
		
		Website facebook = new Website("Facebook", "an online social media and social networking service", 1234234);
		Website twitter = new Website("Twitter", "an online news and social networking service", 4321543);
		Website wikipedia = new Website("Wikipedia", "a free online encyclopedia", 3456654);
		Website cnn = new Website("CNN", "an American basic cable and satellite television news channel", 6543345);
		Website cnet = new Website("CNET", "an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics", 5433455);
		Website gizmodo = new Website("Gizmodo", "a design, technology, science and science fiction website that also writes articles on politics", 4322345);
		
		result = result + websiteDao.createWebsiteForDeveloper(aliceId, facebook);
		result = result + websiteDao.createWebsiteForDeveloper(bobId, twitter);
		result = result + websiteDao.createWebsiteForDeveloper(charlieId, wikipedia);
		result = result + websiteDao.createWebsiteForDeveloper(aliceId, cnn);
		result = result + websiteDao.createWebsiteForDeveloper(bobId, cnet);
		result = result + websiteDao.createWebsiteForDeveloper(charlieId, gizmodo);
		
		return result;
	}
	
	private static int insertWebsiteRole() {
		int result = 0;
		
		int facebookId = websiteDao.findWebsiteByName("facebook").getId();
		int twitterId = websiteDao.findWebsiteByName("twitter").getId();
		int wikipediaId = websiteDao.findWebsiteByName("wikipedia").getId();
		int cnnId = websiteDao.findWebsiteByName("cnn").getId();
		int cnetId = websiteDao.findWebsiteByName("cnet").getId();
		int gizmodoId = websiteDao.findWebsiteByName("gizmodo").getId();
		
		int aliceId = developerDao.findDeveloperByUsername("alice").getId();
		int bobId = developerDao.findDeveloperByUsername("bob").getId();
		int charlieId = developerDao.findDeveloperByUsername("charlie").getId();
		
		int editorId = roleDao.findRoleByName("editor").getId();
		int adminId = roleDao.findRoleByName("admin").getId();
				
		result = result + websiteRoleDao.assignWebsiteRole(bobId, facebookId, editorId);
		result = result + websiteRoleDao.assignWebsiteRole(charlieId, facebookId, adminId);
		
		result = result + websiteRoleDao.assignWebsiteRole(charlieId, twitterId, editorId);
		result = result + websiteRoleDao.assignWebsiteRole(aliceId, twitterId, adminId);
		
		result = result + websiteRoleDao.assignWebsiteRole(aliceId, wikipediaId, editorId);
		result = result + websiteRoleDao.assignWebsiteRole(bobId, wikipediaId, adminId);
		
		result = result + websiteRoleDao.assignWebsiteRole(bobId, cnnId, editorId);
		result = result + websiteRoleDao.assignWebsiteRole(charlieId, cnnId, adminId);
		
		result = result + websiteRoleDao.assignWebsiteRole(charlieId, cnetId, editorId);
		result = result + websiteRoleDao.assignWebsiteRole(aliceId, cnetId, adminId);
		
		result = result + websiteRoleDao.assignWebsiteRole(aliceId, gizmodoId, editorId);
		result = result + websiteRoleDao.assignWebsiteRole(bobId, gizmodoId, adminId);
		
		return result;
	}
	
	private static int insertPage() {
		int result = 0;
		
		int wikipediaId = websiteDao.findWebsiteByName("wikipedia").getId();
		int cnnId = websiteDao.findWebsiteByName("cnn").getId();
		int cnetId = websiteDao.findWebsiteByName("cnet").getId();
		int gizmodoId = websiteDao.findWebsiteByName("gizmodo").getId();
		
		Page home = new Page("Home", "Landing page", 123434);
		Page about = new Page("About", "Website description", 234545);
		Page contact = new Page("Contact", "Addresses, phones, and contact info", 345656);
		Page preferences = new Page("Preferences", "Where users can configure their preferences", 456776);
		Page profile = new Page("Profile", "Users can configure their personal information", 567878);
		
		result = result + pageDao.createPageForWebsite(cnetId, home);
		result = result + pageDao.createPageForWebsite(gizmodoId, about);
		result = result + pageDao.createPageForWebsite(wikipediaId, contact);
		result = result + pageDao.createPageForWebsite(cnnId, preferences);
		result = result + pageDao.createPageForWebsite(cnetId, profile);
		
		return result;
	}
	
	private static int insertPageRole() {
		int result = 0;
		
		int homeId = 0;
		int aboutId = 0;
		int contactId = 0;
		int preferencesId = 0;
		int profileId = 0;
		
		Collection<Page> pageList = pageDao.findAllPage();
		for(Page page : pageList) {
			if(page.getTitle().equals("Home"))
				homeId = page.getId();
			else if(page.getTitle().equals("About"))
				aboutId = page.getId();
			else if(page.getTitle().equals("Contact"))
				contactId = page.getId();
			else if(page.getTitle().equals("Preferences"))
				preferencesId = page.getId();
			else if(page.getTitle().equals("Profile"))
				profileId = page.getId();
		}
		
		int aliceId = developerDao.findDeveloperByUsername("alice").getId();
		int bobId = developerDao.findDeveloperByUsername("bob").getId();
		int charlieId = developerDao.findDeveloperByUsername("charlie").getId();
				
		int editorId = roleDao.findRoleByName("editor").getId();
		int reviewerId = roleDao.findRoleByName("reviewer").getId();
		int writerId = roleDao.findRoleByName("writer").getId();
		
		result = result + pageRoleDao.assignPageRole(aliceId, homeId, editorId);
		result = result + pageRoleDao.assignPageRole(bobId, homeId, reviewerId);
		result = result + pageRoleDao.assignPageRole(charlieId, homeId, writerId);
		
		result = result + pageRoleDao.assignPageRole(bobId, aboutId, editorId);
		result = result + pageRoleDao.assignPageRole(charlieId, aboutId, reviewerId);
		result = result + pageRoleDao.assignPageRole(aliceId, aboutId, writerId);
		
		result = result + pageRoleDao.assignPageRole(charlieId, contactId, editorId);
		result = result + pageRoleDao.assignPageRole(aliceId, contactId, reviewerId);
		result = result + pageRoleDao.assignPageRole(bobId, contactId, writerId);
		
		result = result + pageRoleDao.assignPageRole(aliceId, preferencesId, editorId);
		result = result + pageRoleDao.assignPageRole(bobId, preferencesId, reviewerId);
		result = result + pageRoleDao.assignPageRole(charlieId, preferencesId, writerId);
		
		result = result + pageRoleDao.assignPageRole(bobId, profileId, editorId);
		result = result + pageRoleDao.assignPageRole(charlieId, profileId, reviewerId);
		result = result + pageRoleDao.assignPageRole(aliceId, profileId, writerId);
		
		return result;
	}
	
	private static int insertWidget() {
		int result = 0;
		
		int homeId = 0;
		int aboutId = 0;
		int contactId = 0;
		int preferencesId = 0;
		
		Collection<Page> pageList = pageDao.findAllPage();
		for(Page page : pageList) {
			if(page.getTitle().equals("Home"))
				homeId = page.getId();
			else if(page.getTitle().equals("About"))
				aboutId = page.getId();
			else if(page.getTitle().equals("Contact"))
				contactId = page.getId();
			else if(page.getTitle().equals("Preferences"))
				preferencesId = page.getId();
		}
				
		HeadingWidget head123 = new HeadingWidget("head123", "heading", 0, "Welcome", null, null, 0, 0, 1);
		HtmlWidget post234 = new HtmlWidget("post234", "html", 0, "<p>Lorem</p>", null, null, 0, 0, "<p>Lorem</p>");
		HeadingWidget head345 = new HeadingWidget("head345", "heading", 1, "Hi", null, null, 0, 0, 1);
		HtmlWidget intro456 = new HtmlWidget("intro456", "html", 2, "<h1>Hi</h1>", null, null, 0, 0, "<h1>Hi</h1>");
		ImageWidget image345 = new ImageWidget("image345", "image", 3, null, null, null, 100, 50, "/img/567.png");
		YoutubeWidget video456 = new YoutubeWidget("video456", "youtube", 0, null, null, null, 300, 400, "https://youtu.be/h67VX51QXiQ", true, true);
		
		result = result + widgetDao.createWidgetForPage(homeId, head123);
		result = result + widgetDao.createWidgetForPage(aboutId, post234);
		result = result + widgetDao.createWidgetForPage(contactId, head345);
		result = result + widgetDao.createWidgetForPage(contactId, intro456);
		result = result + widgetDao.createWidgetForPage(contactId, image345);
		result = result + widgetDao.createWidgetForPage(preferencesId, video456);
		
		return result;
	}
	
	private static int update1() {
		int result = 0;
				
		int charlieId = developerDao.findDeveloperByUsername("charlie").getId();
		
		Phone phone = new Phone("1234567890", true);
		phoneDao.createPhoneForDeveloper(charlieId, phone);
		
		Collection<Phone> phoneList = phoneDao.findAllPhoneOfPerson(charlieId);
		for(Phone ph : phoneList) {
			if(ph.isPrimary()) {
				Phone newPhone = new Phone(ph.getId(), "333-444-5555", true);
				result = phoneDao.updatePhone(ph.getId(), newPhone);
				break;
			}
		}
		
		return result;
	}
	
	private static int update2() {
		int result = 0;
		
		Widget head345 = new Widget();
		
		Collection<Widget> widList = widgetDao.findAllWidget();
		for(Widget widget : widList) {
			if(widget.getName().equals("head345"))
				head345 = widget;
		}
		
		Collection<Widget> widgetList = widgetDao.findWidgetsForPage(head345.getPageId()); 
		for(Widget w : widgetList) {
			if(w.getOrder() > head345.getOrder() && w.getOrder() <= 3) {
				w.setOrder(w.getOrder()-1);
				result = result + widgetDao.updateWidget(w.getId(), w);
			}
			else if(w.getOrder() < head345.getOrder() && w.getOrder() >= 3) {
				w.setOrder(w.getOrder()+1);
				result = result + widgetDao.updateWidget(w.getId(), w);
			}
		}
		
		head345.setOrder(3);
		
		result = result + widgetDao.updateWidget(head345.getId(), head345);
		
		return result;
	}
	
	private static int update3() {
		int result = 0;
		
		int websiteId = websiteDao.findWebsiteByName("CNET").getId();
				
		Collection<Page> pageList = pageDao.findPagesForWebsite(websiteId);
		for(Page page : pageList) {
			page.setTitle("CNET - " + page.getTitle());
			result = result + pageDao.updatePage(page.getId(), page);
		}
		return result;
	}
	
	private static int update4() {
		int result = 0;
		
		Page homePage = new Page();
		Collection<Page> pageList = pageDao.findAllPage();
		for(Page page : pageList) {
			if(page.getTitle().equals("Home") || page.getTitle().equals("CNET - Home")) {
				homePage = page;
			}
		}
		
		int charlieId = developerDao.findDeveloperByUsername("charlie").getId();
		int bobId = developerDao.findDeveloperByUsername("bob").getId();
		
		Collection<PageWebsiteRole> pageRoleList = pageRoleDao.findRoleByPage(homePage.getId());
		PageWebsiteRole charlieRole = new PageWebsiteRole();
		PageWebsiteRole bobRole = new PageWebsiteRole();
		for(PageWebsiteRole pageRole : pageRoleList) {
			if(pageRole.getDeveloperId() == charlieId)
				charlieRole = pageRole;
			if(pageRole.getDeveloperId() == bobId)
				bobRole = pageRole;
		}
		
		int temp = charlieRole.getRoleId();
		charlieRole.setRoleId(bobRole.getRoleId());
		bobRole.setRoleId(temp);
		
		result = result + pageRoleDao.updatePageRole(charlieRole.getId(), charlieRole);
		result = result + pageRoleDao.updatePageRole(bobRole.getId(), bobRole);
		
		return result;
	}
	
	private static int delete1() {
		int result = 0;
		
		int aliceId = developerDao.findDeveloperByUsername("alice").getId();
		
		Address address = new Address("street1", "street2", "city", "state", "zip", true);
		addressDao.createAddressForDeveloper(aliceId, address);
		
		Collection<Address> addressList = addressDao.findAddressByPerson(aliceId);
		for(Address add : addressList ) {
			if(add.isPrimary()){
				result = addressDao.deleteAddress(add.getId());
				break;
			}
		}
		return result;
	}
	
	private static int delete2() {
		int result = 0;
		int contactPageId = 0;
		
		Collection<Page> pageList = pageDao.findAllPage();
		for(Page page : pageList) {
			if(page.getTitle().equals("Contact"))
				contactPageId = page.getId();
		}
		
		Collection<Widget> widgetList = widgetDao.findWidgetsForPage(contactPageId);
		int widgetId = 0;
		int order = 0;
		for(Widget widget : widgetList) {
			if(widget.getOrder() > order) {
				widgetId = widget.getId();
				order = widget.getOrder();
			}
		}
		result = widgetDao.deleteWidget(widgetId);
		return result;
	}
	
	private static int delete3() {
		int result = 0;
		
		int wikipediaWebsiteId = websiteDao.findWebsiteByName("wikipedia").getId();
		
		Collection<Page> pageList = pageDao.findPagesForWebsite(wikipediaWebsiteId);
		int pageId = 0;
		Date updated = Date.valueOf("1900-01-01");
		for(Page page : pageList) {
			if(page.getUpdated().after(updated)) {
				pageId = page.getId();
				updated = page.getUpdated();
			}
		}
		result = pageDao.deletePage(pageId);
		return result;
	}
	
	private static int delete4() {
		int result = 0;
		
		int cnetId = websiteDao.findWebsiteByName("CNET").getId();
		result = websiteDao.deleteWebsite(cnetId);
		
		return result;
	}
}
